package step02.assignment;

import step02.assignment.Test01;

class Inval { 
    private static Inval iVal = null;

    private Inval() {
        if(iVal == null)
            iVal = new Inval();
    }

    public static Inval getInstance() {
        if(iVal == null)
            iVal = new Inval();
        return iVal;
    }

    public int Sum(int[] args) {
        int ret = 0;
        for (int add : args) 
            ret += add;
        return ret;
    }

    public int getIntValue(Object... args) {
        int[] ret = new int[args.length];
        for (int i=0; i<args.length; i++)
            ret[i] = Integer.parseInt( (String)args[i] );
        return sum(ret);
    }
}