package uz.rakhmonov.i.homework_19_1.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import uz.rakhmonov.i.homework_19_1.User_Pager
import uz.rakhmonov.i.homework_19_1.databinding.MyPagerItemBinding

class my_Pager_Item_Adapter(val context: Context, val list: List<User_Pager>, val click: click): PagerAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

       val  pagerItemBinding =
            MyPagerItemBinding.inflate(LayoutInflater.from(context), container, false)

//        Picasso.get().load(list[position].image).into(pagerItemBinding.itemImage)
        pagerItemBinding.TVTitle.setText(list[position].title)
        pagerItemBinding.TVText.setText(list[position].text)
        pagerItemBinding.IVImage.setImageResource(list[position].image)

//        pagerItemBinding.TVButton.setOnClickListener {
//            click.onClick()
//        }

        container.addView(pagerItemBinding.root)
        return pagerItemBinding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }

//    override fun getPageTitle(position: Int): CharSequence? {
//        return list[position].title
//    }
}

    interface click {
        fun onClick()
    }
