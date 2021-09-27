package context;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ScenarioContext {


    private static ScenarioContext instance;
    private Map<Context,Object> data;

    private ScenarioContext(){
        this.data = new HashMap<>();
    }

    public static ScenarioContext getScenarioContext(){
        if(Objects.isNull(instance)){
            instance = new ScenarioContext();
        }
        return instance;
    }

    public Object getData(Context key){
        return data.get(key);
    }

    public void  saveData(Context key, Object object){
        data.put(key,object);
    }
}