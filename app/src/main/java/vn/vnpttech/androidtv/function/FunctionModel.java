package vn.vnpttech.androidtv.function;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

import vn.vnpttech.androidtv.R;
import vn.vnpttech.androidtv.app.AppUninstall;

public class FunctionModel {

    private int icon;
    private String id;
    private String name;
    private Intent mIntent;

    public static List<FunctionModel> getFunctionList(Context context) {
        List<FunctionModel> functionModels = new ArrayList<>();

        FunctionModel appUninstall = new FunctionModel();
        appUninstall.setName(context.getString(R.string.uninstall_app));
        appUninstall.setIcon(R.drawable.ic_app_uninstall);
        appUninstall.setIntent(new Intent(context, AppUninstall.class));

        functionModels.add(appUninstall);

        return functionModels;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Intent getIntent() {
        return mIntent;
    }

    public void setIntent(Intent intent) {
        mIntent = intent;
    }
}
