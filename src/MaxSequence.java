public class MaxSequence {

    public static void main(String[] args) {
        String aa = "aabbssd";
        String bb = "bbs";
        Character[] a = new Character[aa.length()];
        Character[] b = new Character[bb.length()];
        for(int i = 0; i < aa.length(); i++) a[i] = aa.charAt(i);
        for(int i = 0; i < bb.length(); i++) b[i] = bb.charAt(i);
        System.out.println(dl(aa.length() - 1, bb.length() - 1, a, b) + 1);
    }

    public static int dl(int l, int k, Object[] a, Object[] b) {
        if(l == 0 || k == 0) {
            return 0;
        }
        if(a[l] == b[k]) {
            return dl(l - 1, k - 1, a, b) + 1;
        }
        return Math.max(dl(l - 1, k, a, b) , dl(l, k - 1, a, b));
    }
}
