package innoapp.com;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {
        private Context mCtx;
        private List<Product> productList;


        public ProductAdapter(Context mCtx, List<Product> productList) {
            this.mCtx = mCtx;
            this.productList = productList;
        }

        @Override
        public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(mCtx);
            View view = inflater.inflate(R.layout.layout_products, null);
            return new ProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ProductViewHolder holder, int position) {
            Product product = productList.get(position);

            holder.textViewTitle.setText(product.getTitle());
            holder.textViewShortDesc.setText(product.getShortdesc());
            holder.textViewRating.setText(String.valueOf(product.getRating()));
            holder.textViewPrice.setText(String.valueOf(product.getPrice()));
         holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));
        }

        @Override
        public int getItemCount() {
            return productList.size();
        }

    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageview);
        }

    }

