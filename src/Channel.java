public class Channel {
    private String channelName;
    private int channelNumber;

    public Channel(){

    }
    public Channel(String channelName, int channelNumber){
        this.channelName = channelName;
        this.channelNumber = channelNumber;
    }
    void setChannelName(String channelName){
        this.channelName = channelName;
    }
    String getChannelName(){
        return channelName;
    }
    void setChannelNumber(int channelNumber){
        this.channelNumber = channelNumber;
    }
    int getChannelNumber(){
        return channelNumber;
    }
    void allChannels(){
        System.out.println(getChannelNumber()+ " - " + getChannelName());
    }
}

