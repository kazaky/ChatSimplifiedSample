package io.marsala.chatsimplifiedsample.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.stfalcon.chatkit.dialogs.DialogsList;
import com.stfalcon.chatkit.dialogs.DialogsListAdapter;
import io.marsala.chatsimplifiedsample.R;
import io.marsala.chatsimplifiedsample.activity.base.BaseDialogsActivity;
import io.marsala.chatsimplifiedsample.data.fixtures.DialogsFixtures;
import io.marsala.chatsimplifiedsample.data.model.Dialog;

public class DialogsActivity extends BaseDialogsActivity {

    public static void open(Context context) {
        context.startActivity(new Intent(context, DialogsActivity.class));
    }

    private DialogsList dialogsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_layout_dialogs);

        dialogsList = (DialogsList) findViewById(R.id.dialogsList);
        initAdapter();
    }

    @Override
    public void onDialogClick(Dialog dialog) {
        MessagesActivity.open(this);
    }

    private void initAdapter() {
        super.dialogsAdapter = new DialogsListAdapter<>(R.layout.item_custom_dialog, super.imageLoader);
        super.dialogsAdapter.setItems(DialogsFixtures.getDialogs());

        super.dialogsAdapter.setOnDialogClickListener(this);
        super.dialogsAdapter.setOnDialogLongClickListener(this);

        dialogsList.setAdapter(super.dialogsAdapter);
    }
}
