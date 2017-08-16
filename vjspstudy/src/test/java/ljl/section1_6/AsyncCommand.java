package ljl.section1_6;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/10/010.
 */
@Scope("prototype")
@Service("AsyncCommand")
public class AsyncCommand implements Command{
    @Override
    public void execute() {
        System.out.println("AsyncCommand execute!");
    }
}
