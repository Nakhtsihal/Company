package telran.view;

import java.util.function.Consumer;

public interface Item {
    String displlayName();
    void perform(InputOutput io);
    boolean isExit();
    static Item of(String name, Consumer<InputOutput> action, boolean isExit){

        return new Item(){

            @Override
            public String displlayName() {
                return name;
            }

            @Override
            public void perform(InputOutput io) {
                action.accept(io);
            }

            @Override
            public boolean isExit() {
                return isExit;
            }
        };
    }
    static Item of(String name, Consumer<InputOutput> action){
        return of(name, action, false);
    }
    static Item exit(){
        return of("Exit", io -> {}, true);
    }
}
