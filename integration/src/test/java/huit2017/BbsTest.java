package huit2017;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import huit2017.entity.Bbs;
import huit2017.mapper.BbsMapper;

public class BbsTest {

    public static void main(String[] args) {
        // resources直下のmybatis-config.xmlを読み込みます(1)
        try (Reader r = Resources.getResourceAsReader("mybatis-config.xml");) {

            // 読み込んだ設定ファイルからSqlSessionFactoryを生成します(2)
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);

            // SQLセッションを取得します(3)
            try (SqlSession session = factory.openSession()) {

                // ActorテーブルのMapperを取得します(4)
                BbsMapper bbsMapper = session.getMapper(BbsMapper.class);
                // Actorテーブルの主キー（actor_id)が１であるレコードを検索します(5)
                Integer bbsId = 1;
                Bbs bbs = bbsMapper.selectByPrimaryKey(bbsId);

                // 取得した内容を確認します
                System.out.println("actor.getActorId    = " + bbs.getBbsId());
                System.out.println("actor.getFirstName  = " + bbs.getComment());
                System.out.println("actor.getLastName   = " + bbs.getUserId());
                System.out.println("actor.getLastUpdate = " + bbs.getCreatedAt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
