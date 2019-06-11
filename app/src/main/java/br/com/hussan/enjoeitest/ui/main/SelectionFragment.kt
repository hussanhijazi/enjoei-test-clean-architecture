package br.com.hussan.enjoeitest.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.hussan.enjoeitest.R
import kotlinx.android.synthetic.main.fragment_selection.*

class SelectionFragment : Fragment() {
    private var title: String? = null

    companion object {
        private const val TITLE = "TITLE"
        fun newInstance(title: String) =
            SelectionFragment().apply {
                arguments = Bundle().apply {
                    putString(TITLE, title)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(TITLE)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtTitle.text = title
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_selection, container, false)
    }

}
