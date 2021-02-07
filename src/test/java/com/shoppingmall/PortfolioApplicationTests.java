/*
 * package com.shoppingmall;
 * 
 * import static org.assertj.core.api.Assertions.assertThat;
 * 
 * import java.io.File; import java.io.IOException; import java.nio.file.Files;
 * import java.util.Date;
 * 
 * import org.junit.jupiter.api.Test; import org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
 * import
 * org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.
 * Replace; import
 * org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest; import
 * org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager; import
 * org.springframework.test.annotation.Rollback; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @DataJpaTest
 * 
 * @AutoConfigureTestDatabase(replace= Replace.NONE) class
 * PortfolioApplicationTests {
 * 
 * 
 * @Autowired private DocumentRepository repo;
 * 
 * @Autowired private TestEntityManager entityManager;
 * 
 * 
 * 
 * @Test
 * 
 * @Rollback(false) void testInsertDocument() throws IOException{ File file =
 * new File("C:\\Users\\User\\Desktop\\Grid.css"); Document document =new
 * Document(); document.setName(file.getName());
 * 
 * byte[] bytes = Files.readAllBytes(file.toPath()); document.setContent(bytes);
 * long fileSize = bytes.length;
 * 
 * document.setSize(fileSize); document.setUploadTime(new Date());
 * 
 * Document savedDoc = repo.save(document);
 * 
 * Document existDoc = entityManager.find(Document.class, savedDoc.getId());
 * 
 * assertThat(existDoc.getSize()).isEqualTo(fileSize);
 * 
 * }
 * 
 * 
 * 
 * 
 * }
 */