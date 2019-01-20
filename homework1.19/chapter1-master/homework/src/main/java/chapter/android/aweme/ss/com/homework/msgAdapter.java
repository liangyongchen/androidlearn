package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.List;

import chapter.android.aweme.ss.com.homework.R;
import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;

public class msgAdapter extends RecyclerView.Adapter<msgAdapter.MyViewHolder> {
    private static final String TAG = "msgAdapter";

    private List<Message> messData;

    private int mNumberItems;

    private final ListItemClickListener mOnClickListener;

    private static int viewHolderCount;

    public msgAdapter(List<Message> data) {
        messData=data;
        mOnClickListener=null;
        viewHolderCount = 0;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.im_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        MyViewHolder viewHolder = new MyViewHolder(view);

        viewHolder.itemView.setBackgroundColor(Color.rgb(60, 60, 60));

        Log.d(TAG, "onCreateViewHolder: number of ViewHolders created: " + viewHolderCount);
        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder numberViewHolder, int position) {
        Log.d(TAG, "onBindViewHolder: #" + position);
        Message message=messData.get(position);
        numberViewHolder.bind(message);
    }

    @Override
    public int getItemCount() {
        mNumberItems=messData.size();
        return mNumberItems;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView User_message;
        private final TextView User;
        private final TextView send_Time;
        private final CircleImageView User_head;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            User = (TextView) itemView.findViewById(R.id.tv_title);
            User_message = (TextView) itemView.findViewById(R.id.tv_description);
            send_Time = (TextView) itemView.findViewById(R.id.tv_time);
            User_head= (CircleImageView) itemView.findViewById(R.id.iv_avatar);
            itemView.setOnClickListener(this);
        }

        public void bind(Message message) {
            int drawableId=0;
            User.setText(message.getTitle());
            User_message.setText(message.getDescription());
            send_Time.setText(message.getTime());

            if(message.getIcon().equals("TYPE_ROBOT"))
            {
                drawableId=R.drawable.session_robot;
            }
            else if(message.getIcon().equals("TYPE_GAME"))
            {
                drawableId=R.drawable.icon_micro_game_comment;
            }
            else if(message.getIcon().equals("TYPE_SYSTEM"))
            {
                drawableId=R.drawable.session_system_notice;
            }
            else if(message.getIcon().equals("TYPE_STRANGER"))
            {
                drawableId=R.drawable.session_stranger;
            }
            else if(message.getIcon().equals("TYPE_USER"))
            {
                drawableId=R.drawable.icon_girl;
            }
            User_head.setImageResource(drawableId);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            if (mOnClickListener != null) {
                mOnClickListener.onListItemClick(clickedPosition);
            }
        }
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }
}

