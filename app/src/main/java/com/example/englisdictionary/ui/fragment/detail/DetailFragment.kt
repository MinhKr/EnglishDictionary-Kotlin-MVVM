package com.example.englisdictionary.ui.fragment.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.englisdictionary.databinding.FragmentDetailBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val word = arguments?.getString("word")
        val mean = arguments?.getString("mean")
        if (word != null && mean != null) {
            binding.txtWord.text = word
            binding.txtMean.text = mean
            binding.txtWordTitle.text = word
        }

        binding.btnBack.setOnClickListener{
            parentFragmentManager.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        /* *
          * Use this factory method to create a new instance of
          * this fragment using the provided parameters.
          *
          * @param param1 Parameter 1.
          * @param param2 Parameter 2.
          * @return A new instance of fragment DetailFragment.*/

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(word: String, mean: String) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString("word", word)
                    putString("mean", mean)
                    putString("wordTitle", word)
                }
            }
    }
}