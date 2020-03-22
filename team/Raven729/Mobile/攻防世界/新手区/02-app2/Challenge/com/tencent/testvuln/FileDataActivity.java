package com.tencent.testvuln;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.testvuln.c.Encryto;

public class FileDataActivity extends a {
    private TextView c;

    public FileDataActivity() {
        super();
    }

    protected void onCreate(Bundle arg3) {
        super.onCreate(arg3);
        this.setContentView(0x7F030002);
        this.c = this.findViewById(0x7F070000);
        this.c.setText(Encryto.decode(this, "9YuQ2dk8CSaCe7DTAmaqAA=="));
    }
}

