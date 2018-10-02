package com.example.okta.nytimes.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.example.okta.nytimes.R;
import com.example.okta.nytimes.database.Article;
import com.example.okta.nytimes.model.search.Doc;
import com.example.okta.nytimes.ui.deatilarticle.DetailArticleActivity;
import com.example.okta.nytimes.widget.ItemClickListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by IT-Gogobli on 5/18/2018.
 */

public class RVListArticleDatabase extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public final int VIEW_ITEM = 1;
    public final int VIEW_PROG = 0;

    private List<Article> contentItems;

    public void setContentItems(List<Article> contentItems) {
        this.contentItems = contentItems;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        if (viewType == VIEW_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, parent, false);
            vh = new TextViewHolder(v);
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_loading_item, parent, false);
            vh = new ProgressViewHolder(v);
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RVListArticleDatabase.TextViewHolder) {
            final Context context = holder.itemView.getContext();
            final String imgurl = contentItems.get(position).getImgurl()!= null ? contentItems.get(position).getImgurl() : "-";
            final String snippet = contentItems.get(position).getSnippet();
            final String tgl = contentItems.get(position).getTgl() == null ? " " : contentItems.get(position).getTgl();
            final String headline = contentItems.get(position).getHeadline();
            String API_IMAGE_BASE_URL = "http://www.nytimes.com/";
            GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(((TextViewHolder) holder).IVItemArticle);
            Glide.with(context)
                    .load(API_IMAGE_BASE_URL + imgurl)
                    .placeholder(R.color.greytoblack)
                    .into(imageViewTarget);
            ((TextViewHolder) holder).TVHeadlineArticle.setText(headline);
            ((TextViewHolder) holder).TVTglArticle.setText(tgl);
            ((TextViewHolder) holder).TVSnipArticle.setText(snippet);
            ((TextViewHolder) holder).setItemClickListener((v, pos) -> {
                Intent DetailArticle = new Intent(context, DetailArticleActivity.class);
                DetailArticle.putExtra("imgurl", imgurl);
                DetailArticle.putExtra("snippet", snippet);
                DetailArticle.putExtra("tgl", tgl);
                DetailArticle.putExtra("headline", headline);
                context.startActivity(DetailArticle);
            });
        } else {
            ((ProgressViewHolder) holder).progressBar.setIndeterminate(true);
        }
    }

    @Override
    public int getItemCount() {
        return contentItems == null ? 0 : contentItems.size();
    }


    public void addItem(final Article newmenus, final int position) {
        contentItems.add(position, newmenus);
        notifyItemChanged(position);
    }

    @Override
    public int getItemViewType(int position) {
        return contentItems.get(position) != null ? VIEW_ITEM : VIEW_PROG;
    }

    public static class ProgressViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;

        public ProgressViewHolder(View v) {
            super(v);
            progressBar = (ProgressBar) v.findViewById(R.id.progressBar1);
        }
    }

    public class TextViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView IVItemArticle;
        public TextView TVSnipArticle;
        public TextView TVTglArticle;
        public TextView TVHeadlineArticle;

        private ItemClickListener itemClickListener;

        public TextViewHolder(View itemView) {
            super(itemView);
            IVItemArticle = itemView.findViewById(R.id.itemIcon);
            TVSnipArticle = itemView.findViewById(R.id.itemSnippet);
            TVTglArticle = itemView.findViewById(R.id.itemTanggal);
            TVHeadlineArticle = itemView.findViewById(R.id.itemTitle);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            this.itemClickListener.onItemClick(view, getLayoutPosition());
        }

        public void setItemClickListener(ItemClickListener ic) {
            this.itemClickListener = ic;
        }

    }
}
