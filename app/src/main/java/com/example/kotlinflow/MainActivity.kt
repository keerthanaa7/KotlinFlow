package com.example.kotlinflow

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlinflow.ui.theme.KotlinFlowTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        val flowViewModel = ViewModelProvider(this).get(FlowViewModel::class.java)
        lifecycleScope.launch {

        }


        // normal xml way
      /*  setContentView(R.layout.activity_view)

        val myflow = flow<Int> {
            for (i in 1..100) {
                emit(i)
                delay(1000)
            }
        }

        val simpletextView = findViewById<TextView>(R.id.simple_textview)
        CoroutineScope(Dispatchers.Main).launch {
            myflow.collect{
                Log.d("MainActivity", "my flow value ${it}")
                simpletextView.setText("my flow value is ${it}")
            }
        }*/
     /*   val myflow = flow<Int> {
            for(i in 1..100){
                emit(i)
                delay(1000)
            }
        }*/


     //   setContent {
           /* val flowViewModel = viewModel<FlowViewModel>()
            val flowViewModelState = flowViewModel.flowViewModel.collectAsState(1).value
            val flowState = myflow.collectAsState(1).value*/
            //Text(text = "flow value is ${flowViewModelState}", modifier = Modifier.fillMaxWidth(), fontSize = 24.sp,)

         /*  var mainviewModel = viewModel<MainActivityViewModel>()
            mainviewModel.result.observe(this,
                {Log.d("MainActivity", "count ${it}")})*/


     //   }

    }
}
