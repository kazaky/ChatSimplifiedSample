package io.marsala.chatsimplifiedsample.features.demo.custom.holder.holders.messages;

import android.view.View;

import com.stfalcon.chatkit.messages.MessageHolders;
import io.marsala.chatsimplifiedsample.R;
import io.marsala.chatsimplifiedsample.common.data.model.Message;

/*
 * Created by troy379 on 05.04.17.
 */
public class CustomIncomingImageMessageViewHolder
        extends MessageHolders.IncomingImageMessageViewHolder<Message> {

    private View onlineIndicator;

    public CustomIncomingImageMessageViewHolder(View itemView) {
        super(itemView);
        onlineIndicator = itemView.findViewById(R.id.onlineIndicator);
    }

    @Override
    public void onBind(Message message) {
        super.onBind(message);

        boolean isOnline = message.getUser().isOnline();
        if (isOnline) {
            onlineIndicator.setBackgroundResource(R.drawable.shape_bubble_online);
        } else {
            onlineIndicator.setBackgroundResource(R.drawable.shape_bubble_offline);
        }
    }
}