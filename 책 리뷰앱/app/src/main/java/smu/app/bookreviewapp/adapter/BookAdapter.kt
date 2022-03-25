package smu.app.bookreviewapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import smu.app.bookreviewapp.databinding.ItemBookBinding
import smu.app.bookreviewapp.model.Book


class BookAdapter(val clickListener: (Book) -> Unit): ListAdapter<Book, BookAdapter.BookItemViewHolder> (diffUtil){
    inner class BookItemViewHolder(private val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root){
        // 데이터를 가져와서 바인드해주는 역할의 함수
        fun bind(bookModel:Book){
            binding.titleTextView.text = bookModel.title
            binding.discriptionTextView.text = bookModel.description

            Glide
                .with(binding.coverImageView.context)
                .load(bookModel.coverSmallUrl)
                .into(binding.coverImageView)

            binding.root.setOnClickListener {
                clickListener(bookModel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookItemViewHolder {
        // 미리 만들어진 뷰홀더가 없을 경우에 새로 생성하는 함수
        return BookItemViewHolder(ItemBookBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: BookItemViewHolder, position: Int) {
        // 실제로 뷰홀더에 데이ㅓ를 바인드해주는 함수
        holder.bind(currentList[position])
    }

    //뷰의 포지션이 변경되었을때 같은 아이템이 올라오면 다시 할당할 필요가 없기 때문에 같은 아이템인지 판단하는 것
    companion object{
        val diffUtil = object :DiffUtil.ItemCallback<Book>(){
            override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem.id == newItem.id
            }

        }
    }
}