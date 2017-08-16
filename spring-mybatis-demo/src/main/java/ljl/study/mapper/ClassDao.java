package ljl.study.mapper;

import ljl.entity.ClassEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */

public interface ClassDao {
    public List<ClassEntity> selectClassList();
}
