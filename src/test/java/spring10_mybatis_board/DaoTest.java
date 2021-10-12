package spring10_mybatis_board;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vision.mybatis_board.dao.BDao;
import com.vision.mybatis_board.dto.BDto;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DaoTest {

   @Setter(onMethod_ = @Autowired(required=false))
   private BDao bdao;
   
   @Test
   public void testContentView() {
      BDto bdto = bdao.contentView(1);
      log.info(bdto);
   }
   
   @Test
   public void testWrite() {
      bdao.write("123", "123", "123");
   }

   @Test
   public void testList() {
      bdao.list().forEach(board -> log.info(board));
   }
   
   @Test
   public void testModify() {

      bdao.modify(1, "22", "22", "22");

   }
   
   @Test
   public void testDelete() {
      bdao.delete(12);
   }
   
   @Test
   public void testReply() {
      bdao.reply(10, "user", "aa", "aa", 0, 0, 0);
   }
   
   @Test
   public void testReply_View() {
      bdao.reply_view(8);
   }
   
   @Test
   public void testUpHit() {
      bdao.upHit(2);
   }
}
