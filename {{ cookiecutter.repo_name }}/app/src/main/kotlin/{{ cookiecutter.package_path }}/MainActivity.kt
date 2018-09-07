package {{ cookiecutter.package_name }}

import android.support.v7.app.AppCompatActivity

/*
 * This class is just a place holder so all the package directories are created.
 */
class MainActivity : AppCompatActivity()
 val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_authentication)

        btn_link_login.setOnClickListener {

            if (!isValidEmail(login_input_email.text.toString().trim())) {
                login_input_email.setError("Username is not Valid");
                login_input_email.requestFocus();
            }
            if (login_input_password.text.toString().trim().length <= 6) {
                login_input_password.setError("Invalid Password");
                login_input_password.requestFocus();
            } else {
                Toast.makeText(this, "Logged in successfully", Toast.LENGTH_LONG).show()
            }
        }

    }

    fun isValidEmail(email: String): Boolean {
        val pattern: Pattern
        val matcher: Matcher
        pattern = Pattern.compile(emailPattern)
        matcher = pattern.matcher(email)
        return matcher.matches()

    }
