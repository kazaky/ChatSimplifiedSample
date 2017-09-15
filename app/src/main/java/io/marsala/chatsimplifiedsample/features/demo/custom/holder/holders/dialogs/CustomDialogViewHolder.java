package io.marsala.chatsimplifiedsample.features.demo.custom.holder.holders.dialogs;

import android.view.View;

import com.stfalcon.chatkit.dialogs.DialogsListAdapter;
import io.marsala.chatsimplifiedsample.R;
import io.marsala.chatsimplifiedsample.common.data.model.Dialog;

/*
 * Created by Anton Bevza on 1/18/17.
 */
public class CustomDialogViewHolder
        extends DialogsListAdapter.DialogViewHolder<Dialog> {

    private View onlineIndicator;

    public CustomDialogViewHolder(View itemView) {
        super(itemView);
        onlineIndicator = itemView.findViewById(R.id.onlineIndicator);
    }

    @Override
    public void onBind(Dialog dialog) {
        super.onBind(dialog);

        if (dialog.getUsers().size() > 1) {
            onlineIndicator.setVisibility(View.GONE);
        } else {
            boolean isOnline = dialog.getUsers().get(0).isOnline();
            onlineIndicator.setVisibility(View.VISIBLE);
            if (isOnline) {
                onlineIndicator.setBackgroundResource(R.drawable.shape_bubble_online);
            } else {
                onlineIndicator.setBackgroundResource(R.drawable.shape_bubble_offline);
            }
        }
    }
}
