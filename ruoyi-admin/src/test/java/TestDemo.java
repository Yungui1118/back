import com.ruoyi.RuoYiApplication;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.kj.domain.Report;
import com.ruoyi.kj.mapper.ReportMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author zheng yang
 * @date 2022/4/30 8:48
 */

@SpringBootTest(classes = RuoYiApplication.class)
public class TestDemo {

    @Autowired
    private ReportMapper reportMapper;

    @Test
    public void test() {
        List<Report> reports = reportMapper.selectRemarks();
        List<Report> result = reports.stream().filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println(result);
    }
}
