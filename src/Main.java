import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.StreamHandler;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Television television = new Television();
        Channel channel1 = new Channel("Match Tv",1);
        Channel channel2 = new Channel("Football 1",2);
        Channel channel3 = new Channel("Mtv",3);
        Channel channel4 = new Channel("Discovery",4);

        Channel[] channels = {channel1, channel2, channel3, channel4};

        System.out.println("""
                              -------------- Commands ----------------
                              
                              Change to next channel     - (next)
                              Change to previous channel - (prev)
                              Go to channel by number    - (number of channel)
                              Go to channel by name      - (name of channel)
                              All channels               - (all)
                              Add one channel            - (add) *under all channels menu                            
                              Quit                       - (quit)
                              
                              ----------------------------------------
                              """);
        System.out.println("\n---------Channels---------");
        System.out.println();
        channel1.allChannels();
        channel2.allChannels();
        channel3.allChannels();
        channel4.allChannels();
        television.setCurrentChannel(channel1);
        while (true) {
            System.out.println("\n---------Current channel--------");
            television.channelInfo();
            System.out.println("\nType command:");
            String command = scanner.next();
            if (Objects.equals(command, "quit")) {
                if (channels.length == 5) {
                    System.out.println("Channel you added will be deleted!\nenter 'ok' to confirm: ");
                    command = scanner.next();
                    while (!Objects.equals(command, "ok")){
                        System.out.println("Wrong command");
                        command = scanner.next();
                    }
                }
                System.out.println("Goodbye");
                break;
            }
            switch (command.toLowerCase()) {
                case "all" -> {
                    System.out.println("All channels:");
                    for (Channel channel : channels) {
                        channel.allChannels();
                    }
                    System.out.println("\nEnter 'add' to add channel\nYou can add only one channel: ");
                    command = scanner.next();
                    if (Objects.equals(command, "add")) {
                        if (channels.length == 5){
                            System.out.println("""
                                    
                                    You already added 1 channel!
                                    If you want to change added channel - enter 'change':""");
                            command = scanner.next();
                            if (Objects.equals(command, "change")){
                                Channel channel5 = new Channel();
                                System.out.println("Set channel number:");
                                channel5.setChannelNumber(scanner.nextInt());
                                System.out.println("Set channel name:");
                                channel5.setChannelName(scanner.next());
                                channels = new Channel[]{channel1, channel2, channel3, channel4, channel5};
                                System.out.println("Channel changed!");
                                System.out.println("\nAll channels:");
                                for (Channel channel : channels) {
                                    channel.allChannels();
                                }
                            }else {
                                System.out.println("Wrong command!");
                            }
                        } else {
                            Channel channel5 = new Channel();
                            System.out.println("Set channel number:");
                            channel5.setChannelNumber(scanner.nextInt());
                            System.out.println("Set channel name:");
                            channel5.setChannelName(scanner.next());
                            channels = new Channel[]{channel1, channel2, channel3, channel4, channel5};
                            System.out.println("\nChannel added!");
                            System.out.println("\nAll channels:");
                            for (Channel channel : channels) {
                                channel.allChannels();
                            }
                        }
                    } else if (Objects.equals(command, "current")) {
                    } else {
                        System.out.println("Wrong command!");
                        System.out.println();
                    }
                    break;
                }
                case "next" -> {
                    int a = television.getCurrentChannel().getChannelNumber();
                    int b = channels.length;
                    if (a == b) {
                        television.setCurrentChannel(channels[0]);
                    } else if (television.getCurrentChannel() == channels[a - 1]) {
                        television.setCurrentChannel(channels[a]);
                    }
                    break;
                }
                case "prev" -> {
                    int a = television.getCurrentChannel().getChannelNumber();
                    int b = channels.length;
                    if (a == 1) {
                        television.setCurrentChannel(channels[b - 1]);
                    } else if (television.getCurrentChannel() == channels[a - 1]) {
                        television.setCurrentChannel(channels[a - 2]);
                    }
                    break;
                }
                case "1" -> {
                    television.setCurrentChannel(channels[0]);
                    break;
                }
                case "2" -> {
                    television.setCurrentChannel(channels[1]);
                    break;
                }
                case "3" -> {
                    television.setCurrentChannel(channels[2]);
                    break;
                }
                case "4" -> {
                    television.setCurrentChannel(channels[3]);
                    break;
                }
                case "5" -> {
                    if (channels.length == 5){
                        television.setCurrentChannel(channels[4]);
                    } else {
                        System.out.println("Wrong channel");
                    }
                    break;
                }
                default -> {
                    System.out.println("Wrong channel");
                    break;
                }
            }

        }

    }
}