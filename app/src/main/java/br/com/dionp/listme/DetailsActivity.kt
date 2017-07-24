package br.com.dionp.listme

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        btnSave.setOnClickListener {

            if (!checkEdtIsEmpty()) {
                val name = edtName.text.toString()
                val age = edtAge.text.toString().toInt()
                val person = Person(name, age)

                val intent = Intent()
                intent.putExtra(EXTRA_PERSON, person)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }

    }

    fun checkEdtIsEmpty(): Boolean {

        if (edtName.text.toString() == "") {
            edtName.error = getString(R.string.name_error)
            return true
        }
        if (edtAge.text.toString() == "") {
            edtAge.error = getString(R.string.age_error)
            return true
        }
        return false
    }

    companion object {
        val EXTRA_PERSON = "person"
    }
}
