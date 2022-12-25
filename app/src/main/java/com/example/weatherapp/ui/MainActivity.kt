package com.example.weatherapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.*
import com.example.weatherapp.databinding.ActivityMainBinding
import com.sawaf.weatherappex.tools.*
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val viewModel: MainViewModel by viewModels()
    @Inject lateinit var  person:Person
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(this,person.name , Toast.LENGTH_SHORT).show()
        val spinner = binding.activityMainSpinner

        val adapter = ArrayAdapter(
            this,
            R.layout.spinner,
            resources.getStringArray(R.array.Country)
        )
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                viewModel.getCountryWeather(p2)

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        observe(viewModel.backgroundView) {
            binding.root.setBackgroundResource(it)
        }

        observe(viewModel.uiStateWeather) {
            when (it) {
                is UIStateWeather.LoadingState -> {
                    binding.activityMainProgress.toVisible()
                    binding.activityMainCurrentTempTxtView.toGone()
                    binding.activityMainConditionTxtView.toGone()
                    binding.activityMainImageView.toGone()
                    binding.activityMainMinTempTxtView.toGone()
                    binding.activityMainMaxTempTxtView.toGone()
                    binding.activityMainRecyclerview.toGone()
                }
                is UIStateWeather.sucessState -> {
                    //progressbar
                    binding.activityMainProgress.toGone()
                    //temp
                    binding.activityMainCurrentTempTxtView.toVisible()
                    val uiModel = MainUi.toUiModel(it.weather.main!!)
                    binding.activityMainCurrentTempTxtView.getInputString("${uiModel.temp}C")
                    //conditionWeather
                    binding.activityMainConditionTxtView.toVisible()
                    val uiModelList = WeatherUiList.toUiModel(it.weather.weather!!.get(0))
                    binding.activityMainConditionTxtView.getInputString(uiModelList.main!!)
                    //imageview
                    binding.activityMainImageView.toVisible()
                    val icon: String = uiModelList.icon!!
                    binding.activityMainImageView.loadImage(icon, context = this)
                }
                is UIStateWeather.ErrorState -> {
                    binding.activityMainProgress.toGone()
                    binding.activityMainCurrentTempTxtView.toGone()
                    binding.activityMainConditionTxtView.toGone()
                    binding.activityMainImageView.toGone()
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    Log.d("TAG", "onCreate: "+it.message)
                }
                is UIStateWeather.CheckConnState -> {
                    val intent = Intent(this, CheckConnectionActivity::class.java)
                    startActivity(intent)
                }
                else -> {
                }
            }
        }

        observe(viewModel.uiStateMinMaxTemp) {
            when (it) {
                is UIStateMinMaxTemp.LoadingState -> {
                    binding.activityMainProgress.toVisible()
                }
                is UIStateMinMaxTemp.sucessState -> {
                    //progressbar
                    binding.activityMainProgress.toGone()
                    //mintemp
                    binding.activityMainMinTempTxtView.visibility = View.VISIBLE
                    val uiModelMinMax = Main2UiMinMax.toUiModel(it.weather.list?.get(1)?.main!!)
                    binding.activityMainMinTempTxtView.getInputString(uiModelMinMax.temp_min.toString())
                    //maxtemp
                    binding.activityMainMaxTempTxtView.visibility = View.VISIBLE
                    binding.activityMainMaxTempTxtView.getInputString(uiModelMinMax.temp_max.toString())
                    //recycler view
                    binding.activityMainRecyclerview.visibility = View.VISIBLE
                    val recyclerview = binding.activityMainRecyclerview
                    // this creates a vertical layout Manager
                    recyclerview.layoutManager = LinearLayoutManager(this)
                    val uiModelMinMaxList = MinMaxTempUi.toUiModel(it.weather)
                    var adapter = MyRecyclerViewAdapter(uiModelMinMaxList.list)
                    recyclerview.adapter = adapter
                }
                is UIStateMinMaxTemp.ErrorState -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
                is UIStateMinMaxTemp.CheckConnState -> {
                    val intent = Intent(this, CheckConnectionActivity::class.java)
                    startActivity(intent)
                }
                else -> {

                }
            }

        }



    }
}


