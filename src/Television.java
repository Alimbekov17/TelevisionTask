public class Television {
    private int maxChannels;
    private Channel channel;

    public Television(){

    }
    public Television(int maxChannels){
        this.maxChannels = maxChannels;
    }
    void setCurrentChannel(Channel channel){
        this.channel = channel;
    }

    Channel getCurrentChannel(){
        return channel;
    }
    void setMaxChannels(int maxChannels){
        this.maxChannels = maxChannels;
    }
    int getMaxChannels(){
        return maxChannels;
    }
    void setChannel(Channel channel){
        this.channel = channel;
    }
    Channel getChannel(){
        return channel;
    }
    void channelInfo(){
        System.out.println();
        System.out.println("          " + getCurrentChannel().getChannelNumber() + " - "
                + getCurrentChannel().getChannelName());
    }
}
