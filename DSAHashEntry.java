public class DSAHashEntry {
       
         String key;
         Object value;
         int state;//0=empty,1=full,-1=removed
        public DSAHashEntry(){
            key=null;
            value=null;
            state=0;
         }
        public DSAHashEntry(String inKey,Object inValue){
            key=inKey;
            value=inValue;
            state=1;
         }
           public String getKey()
    {
        return key;
    }

    public Object getValue()
    {
        return value;
    }

    public int getState()
    {
        return state;
    }

    public void set(String inKey, Object inValue, int inState)
    {
        key = inKey;
        value = inValue;
        state = inState;
    }

    
    
}
