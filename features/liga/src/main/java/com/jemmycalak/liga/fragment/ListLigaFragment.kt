package com.jemmycalak.liga.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jemmycalak.liga.R
import com.jemmycalak.liga.databinding.FragmentListLigaBinding
import com.jemmycalak.liga.viewmodel.ListLigaViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class ListLigaFragment : Fragment() {


    val vModel: ListLigaViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentListLigaBinding.inflate(inflater, container, false).apply {
            viewModel = vModel
        }.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        vModel.getDataLiga("England")
    }

}