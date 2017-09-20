package com.abdallahmurad.the_project.commviewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.abdallahmurad.the_project.R;
import com.abdallahmurad.the_project.commmodels.Post;

import static com.abdallahmurad.the_project.R.id.imageView;

/**
 * Created by AbdallahMurad on 8/3/2017.
 */

public class PostViewHolder extends RecyclerView.ViewHolder {
    public TextView titleView;
    public TextView authorView;
    public ImageView starView;
    public TextView numStarsView;
    public TextView bodyView;
    public ImageView imgView;
    public PostViewHolder(View itemView) {
        super(itemView);
        titleView = (TextView) itemView.findViewById(R.id.post_title);
        authorView = (TextView) itemView.findViewById(R.id.post_author);
        starView = (ImageView) itemView.findViewById(R.id.star);
        numStarsView = (TextView) itemView.findViewById(R.id.post_num_stars);
        bodyView = (TextView) itemView.findViewById(R.id.post_body);
        imgView = (ImageView) itemView.findViewById(imageView);

    }

    public void bindToPost(Post post, View.OnClickListener starClickListener ) {
        titleView.setText(post.title);
        authorView.setText(post.author);
        numStarsView.setText(String.valueOf(post.starCount));
        starView.setOnClickListener(starClickListener);
//        Picasso.with(getActivity().getApplicationContext()).load(post.imgUrl).into(imgView);
    }
}
