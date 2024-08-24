package com.harkhark.feature.hello

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.harkhark.core.ui.BaseFragment
import com.harkhark.feature.hello.databinding.FragmentSampleBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.util.Timer

@AndroidEntryPoint
class SampleFragment : BaseFragment<FragmentSampleBinding>(R.layout.fragment_sample) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("onViewCreated")
    }

}