package com.comers.shenwu.stronger

import android.os.AsyncTask

object AsyncTaskHelper {
    @JvmStatic
    fun main(args: Array<String>) {
        TestTask().execute("hahahah")
    }
}

class TestTask : AsyncTask<String, String, String>() {
    override fun onPreExecute() {
        super.onPreExecute()
    }
    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
    }
    override fun doInBackground(vararg params: String?): String {
        var  str="do what you want to do ! "
        return "jdjdjdjjdd"
    }

    override fun onProgressUpdate(vararg values: String?) {
        super.onProgressUpdate(*values)
    }

}
