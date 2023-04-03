package uz.rakhmonov.i.homework_19_1
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import uz.rakhmonov.i.homework_19_1.adapters.click
import uz.rakhmonov.i.homework_19_1.adapters.my_Pager_Item_Adapter
import uz.rakhmonov.i.homework_19_1.databinding.ActivityMainBinding
import uz.rakhmonov.i.homework_19_1.myData.Data


class MainActivity : AppCompatActivity(),click{
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var list: ArrayList<User_Pager>
    lateinit var myPagerItemAdapter: my_Pager_Item_Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        list = ArrayList()
        list.add(User_Pager("Wellcome",Data.text_1, R.drawable.rainly))
        list.add(User_Pager("Xikoyalar dunyosi", Data.text_2, R.drawable.rainly_2))
        list.add(User_Pager("Kitob ortidan", Data.text_3, R.drawable.rainly_3))
        list.add(User_Pager("Bizga qo'shiling", Data.text_4, R.drawable.rainly_4))

        myPagerItemAdapter = my_Pager_Item_Adapter(this, list,this)
        binding.myVP.adapter = myPagerItemAdapter

        binding.myTabLayout.setupWithViewPager(binding.myVP)

        binding.TVButton.setOnClickListener {
            onClick()
        }

        }
    override fun onClick() {
        binding.myVP.setCurrentItem(getItem(+1), true)
    }

    override fun onBackPressed() {
        binding.myVP.setCurrentItem(getItem(-1), true)
    }


    private fun getItem(i: Int): Int {
        return binding.myVP.currentItem + i
    }


}