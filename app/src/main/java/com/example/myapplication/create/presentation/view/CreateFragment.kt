import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.create.domain.usecase.OpenDialogAddressOfMatch
import com.example.myapplication.create.domain.usecase.OpenDialogDateOfMatch
import com.example.myapplication.create.domain.usecase.OpenDialogTimeOfMatch
import com.example.myapplication.create.domain.usecase.OpenDialogTypeOfSports
import com.example.myapplication.databinding.FragmentCreateBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class CreateFragment : Fragment() {

    private lateinit var binding: FragmentCreateBinding
    private lateinit var textView_address: TextView
    private lateinit var textView_date: TextView
    private lateinit var textView_time: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView_address = view.findViewById(R.id.textView_address)
        textView_address.setOnClickListener {
            val dialog = OpenDialogAddressOfMatch(textView_address)
            dialog.show(parentFragmentManager, "MyDialog")
        }

        textView_date = view.findViewById(R.id.textView_date)
        textView_date.setOnClickListener {
            showDatePickerDialog()
        }

        textView_time = view.findViewById(R.id.textView_time)
        textView_time.setOnClickListener {
            showTimePickerDialog()
        }

        view.findViewById<Button>(R.id.btn_type_of_sports)?.setOnClickListener {
            val dialog = OpenDialogTypeOfSports()
            dialog.show(parentFragmentManager, "MyDialog")
        }
    }

    private fun showDatePickerDialog() {
        val datePickerDialog = OpenDialogDateOfMatch { selectedDate ->
            GlobalScope.launch(Dispatchers.Main) {
                updateSelectedDate(selectedDate)
            }
        }
        datePickerDialog.show(parentFragmentManager, "DatePickerDialog")
    }

    private fun updateSelectedDate(date: Date) {
        val formattedDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(date)
        textView_date.text = formattedDate
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = OpenDialogTimeOfMatch { selectedTime ->
            GlobalScope.launch(Dispatchers.Main) {
                updateSelectedTime(selectedTime)
            }
        }
        timePickerDialog.show(parentFragmentManager, "TimePickerDialog")
    }

    private fun updateSelectedTime(time: Date) {
        val formattedTime = SimpleDateFormat("HH:mm", Locale.getDefault()).format(time)
        textView_time.text = formattedTime
    }
}
