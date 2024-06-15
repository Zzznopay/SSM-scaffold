package cc.zzzooo.service.impl;

import cc.zzzooo.mapper.TestMapper;
import cc.zzzooo.pojo.Test;
import cc.zzzooo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: TestServiceImpl
 * Package: cc.zzzooo.service.impl
 * Description:
 *
 * @Author: zzz
 * @Create: 2024/6/15-14:05
 * @Version: 1.0
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> selectAll() {
        return testMapper.selectAll();
    }
}
