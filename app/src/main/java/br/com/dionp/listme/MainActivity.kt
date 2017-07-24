package br.com.dionp.listme

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val listPerson: MutableList<Person> by lazy { mutableListOf<Person>() }
    private var adapter: ArrayAdapter<Person>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            startActivityForResult(intent, REQUEST_INSERT)
        }

        listview.setOnItemClickListener { _, view, position,  _ ->
            showSnack(view, listPerson[position].name)
        }

        adapter = ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1, listPerson)
        listview.adapter = adapter
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_INSERT && resultCode == Activity.RESULT_OK) {
            val person = data?.getSerializableExtra(DetailsActivity.EXTRA_PERSON) as? Person
            if (person != null) {
                listPerson.add(person)
                listPerson.sortBy { it.name }
                adapter?.notifyDataSetChanged()
            }
        }
    }

    companion object {
        val REQUEST_INSERT = 0
    }
}
