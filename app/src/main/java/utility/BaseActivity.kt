package utility

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.ashish.demo.R

abstract class BaseActivity<B : ViewBinding> : AppCompatActivity() {

    lateinit var binding: B

    companion object{
        private const val URL_REGEX = "((http|https)://)(www.)?” \n" +
                "+ “[a-zA-Z0-9@:%._\\\\+~#?&//=]{2,256}\\\\.[a-z]” \n" +
                "+ “{2,6}\\\\b([-a-zA-Z0-9@:%._\\\\+~#?&//=]*)"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
        onObserve()
        /**
         * To Prevent from tap jacking
         */
        binding.root.filterTouchesWhenObscured = true
    }

    abstract fun onObserve()

    abstract fun getViewBinding(): B

    fun showAlertDialog(dialogBuilder: AlertDialog.Builder.() -> Unit) {
        val builder = AlertDialog.Builder(this)
        builder.dialogBuilder()
        val dialog = builder.create()
        dialog.show()
    }

    fun showErrorDialog(message: String) {
        showAlertDialog {
            setTitle(R.string.app_name)
            setMessage(message)
            positiveButton(getString(R.string.okay_text)) {
            }
            negativeButton {}
        }
    }

    fun AlertDialog.Builder.positiveButton(
        text: String = getString(R.string.okay_text),
        handleClick: (which: Int) -> Unit = {}
    ) {
        this.setPositiveButton(text) { _, which -> handleClick(which) }
    }

    fun AlertDialog.Builder.negativeButton(
        text: String = getString(R.string.cancel_text),
        handleClick: (which: Int) -> Unit = {}
    ) {
        this.setNegativeButton(text) { _, which -> handleClick(which) }
    }

    fun showToast(message: String) {
        Toast.makeText(this@BaseActivity, message, Toast.LENGTH_SHORT).show()
    }

    fun String?.isUrlValid(): Boolean =
        (this == null) || this.trim().isEmpty() || !android.util.Patterns.WEB_URL.matcher(this.replace("\\s".toRegex(), "")).matches()

}
