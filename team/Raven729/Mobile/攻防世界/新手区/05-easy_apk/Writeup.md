## Write-up

#### Step-1

JEB逆向后观察MAinActivity中方法

```java
if(new Base64New().Base64Encode(MainActivity.this.findViewById(0x7F0B0075).getText().toString().getBytes()).equals("5rFf7E2K6rqN7Hpiyush7E6S5fJg6rsi5NBf6NGT5rs=")) {
                    Toast.makeText(MainActivity.this, "验证通过!", 1).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "验证失败!", 1).show();
                }
```

可知需要逆向经过变种BASE64编码过的字符串"5rFf7E2K6rqN7Hpiyush`7E6S5fJg6rsi5NBf6NGT5rs="。

#### Step-2

```java
public class Base64New {
    private static final char[] Base64ByteToStr = null;
    private static final int RANGE = 0xFF;
    private static byte[] StrToBase64Byte;

    static {
        Base64New.Base64ByteToStr = new char[]{'v', 'w', 'x', 'r', 's', 't', 'u', 'o', 'p', 'q', '3', '4', '5', '6', '7', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'y', 'z', '0', '1', '2', 'P', 'Q', 'R', 'S', 'T', 'K', 'L', 'M', 'N', 'O', 'Z', 'a', 'b', 'c', 'd', 'U', 'V', 'W', 'X', 'Y', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', '8', '9', '+', '/'};
        Base64New.StrToBase64Byte = new byte[0x80];
    }

    public Base64New() {
        super();
    }

    public String Base64Encode(byte[] arg9) {
        int v7 = 3;
        StringBuilder v3 = new StringBuilder();
        int v1;
        for(v1 = 0; v1 <= arg9.length - 1; v1 += 3) {
            byte[] v0 = new byte[4];
            byte v4 = 0;
            int v2;
            for(v2 = 0; v2 <= 2; ++v2) {
                if(v1 + v2 <= arg9.length - 1) {
                    v0[v2] = ((byte)((arg9[v1 + v2] & 0xFF) >>> v2 * 2 + 2 | v4));
                    v4 = ((byte)(((arg9[v1 + v2] & 0xFF) << (2 - v2) * 2 + 2 & 0xFF) >>> 2));
                }
                else {
                    v0[v2] = v4;
                    v4 = 0x40;
                }
            }

            v0[v7] = v4;
            for(v2 = 0; v2 <= v7; ++v2) {
                if(v0[v2] <= 0x3F) {
                    v3.append(Base64New.Base64ByteToStr[v0[v2]]);
                }
                else {
                    v3.append('=');
                }
            }
        }

        return v3.toString();
    }
}
```

新码表为vwxrstuopq34567ABCDEFGHIJyz012PQRSTKLMNOZabcdUVWXYefghijklmn89+/。

#### Step-3

用04的脚本解得flag{05397c42f9b6da593a3644162d36eb01}

