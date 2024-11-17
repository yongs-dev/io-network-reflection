package mark.ionetworkreflection.javaadv2.io.buffered;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.*;

import static mark.ionetworkreflection.javaadv2.io.buffered.BufferedConst.*;

/**
 * <ul>
 *     <li>1 바이트씩 read, write 시 오버헤드가 큼(10MB -> 10 * 1024 * 1024번 OS 시스템콜 호출)</li>
 *     <li>버퍼를 사용하여 최적화(byte array)</li>
 *     버퍼의 크기가 커진다고 해서 속도가 계속 줄어들지 않는다. 디스크나 파일 시스템에서 데이터를 읽고 쓰는 기본 단위는 보통 4KB, 8KB이기 때문아다.
 *     <li>BufferedStream을 사용해서 자동으로 버퍼 처리가 가능하다.</li>
 *     버퍼를 직접 다루는 것 보다 BufferedStream을 사용하는 경우 동기화로 인해 성능이 조금 떨어진다.
 * </ul>
 */
@Slf4j
public class CreateFileTest {

    @Test
    public void oneByteWriteTest() throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < FILE_SIZE; i++) {
            fos.write(1);
        }
        fos.close();

        long endTime = System.currentTimeMillis();
        log.info("File created: {}, File Size: {}MB, Elapsed Time: {}", FILE_NAME, (FILE_SIZE / 1024 / 1024), (endTime - startTime));
    }

    @Test
    public void oneByteReadTest() throws IOException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();

        int fileSize = 0;
        int data;
        while ((data = fis.read()) != -1) {
            fileSize++;
        }
        fis.close();

        long endTime = System.currentTimeMillis();
        log.info("File Name: {}, File Size: {}MB, Elapsed Time: {}", FILE_NAME, (fileSize / 1024 / 1024), (endTime - startTime));
    }

    @Test
    public void BufferWriteTest() throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();

        byte[] buffer = new byte[BUFFERED_SIZE];
        int bufferIndex = 0;
        for (int i = 0; i < FILE_SIZE; i++) {
            buffer[bufferIndex++] = 1;

            // 버퍼가 가득 차면 쓰고, 버퍼를 비운다
            if (bufferIndex == BUFFERED_SIZE) {
                fos.write(buffer);
                bufferIndex = 0;
            }
        }

        // 끝 부분에 오면 버퍼가 가득차지 않고 남아있을 수 있다. 버퍼에 남은 부분 쓰기
        if (bufferIndex > 0) {
            fos.write(buffer, 0, bufferIndex);
        }
        fos.close();

        long endTime = System.currentTimeMillis();
        log.info("File created: {}, File Size: {}MB, Elapsed Time: {}", FILE_NAME, (FILE_SIZE / 1024 / 1024), (endTime - startTime));
    }

    @Test
    public void bufferReadTest() throws IOException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();

        byte[] buffer = new byte[BUFFERED_SIZE];
        int fileSize = 0;
        int size;
        while ((size = fis.read(buffer)) != -1) {
            fileSize += size;
        }
        fis.close();

        long endTime = System.currentTimeMillis();
        log.info("File Name: {}, File Size: {}MB, Elapsed Time: {}", FILE_NAME, (fileSize / 1024 / 1024), (endTime - startTime));
    }

    @Test
    public void bufferedStreamWriteTest() throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        BufferedOutputStream bos = new BufferedOutputStream(fos, BUFFERED_SIZE);
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < FILE_SIZE; i++) {
            bos.write(1);
        }
        bos.close();

        long endTime = System.currentTimeMillis();
        log.info("File created: {}, File Size: {}MB, Elapsed Time: {}", FILE_NAME, (FILE_SIZE / 1024 / 1024), (endTime - startTime));
    }

    @Test
    public void bufferedStreamReadTest() throws IOException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        BufferedInputStream bis = new BufferedInputStream(fis, BUFFERED_SIZE);
        long startTime = System.currentTimeMillis();

        int fileSize = 0;
        int data;
        while ((data = bis.read()) != -1) {
            fileSize++;
        }
        bis.close();

        long endTime = System.currentTimeMillis();
        log.info("File Name: {}, File Size: {}MB, Elapsed Time: {}", FILE_NAME, (fileSize / 1024 / 1024), (endTime - startTime));
    }

    @Test
    public void allWriteTest() throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();

        byte[] buffer = new byte[BUFFERED_SIZE];
        for (int i = 0; i < FILE_SIZE; i++) {
            buffer[i] = 1;
        }
        fos.write(buffer);
        fos.close();

        long endTime = System.currentTimeMillis();
        log.info("File created: {}, File Size: {}MB, Elapsed Time: {}", FILE_NAME, (FILE_SIZE / 1024 / 1024), (endTime - startTime));
    }

    @Test
    public void allReadTest() throws IOException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();

        byte[] buffer = fis.readAllBytes();
        fis.close();

        long endTime = System.currentTimeMillis();
        log.info("File Name: {}, File Size: {}MB, Elapsed Time: {}", FILE_NAME, (buffer.length / 1024 / 1024), (endTime - startTime));
    }
}
