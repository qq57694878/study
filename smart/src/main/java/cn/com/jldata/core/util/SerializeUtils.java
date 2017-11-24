package cn.com.jldata.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class SerializeUtils {
    public static final byte[] EMPTY_ARRAY = new byte[0];
    private static Logger logger = LoggerFactory.getLogger(SerializeUtils.class);

    public SerializeUtils() {
    }

    public static Object deserialize(byte[] bytes) {
        Object result = null;
        if (isEmpty(bytes)) {
            return null;
        } else {
            try {
                ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);

                try {
                    ObjectInputStream objectInputStream = new ObjectInputStream(byteStream);

                    try {
                        result = objectInputStream.readObject();
                    } catch (ClassNotFoundException var5) {
                        throw new Exception("Failed to deserialize object type", var5);
                    }
                } catch (Throwable var6) {
                    throw new Exception("Failed to deserialize", var6);
                }
            } catch (Exception var7) {
                logger.error("Failed to deserialize", var7);
            }

            return result;
        }
    }

    public static boolean isEmpty(byte[] data) {
        return data == null || data.length == 0;
    }

    public static byte[] serialize(Object object) {
        byte[] result = null;
        if (object == null) {
            return new byte[0];
        } else {
            try {
                ByteArrayOutputStream byteStream = new ByteArrayOutputStream(128);

                try {
                    if (!(object instanceof Serializable)) {
                        throw new IllegalArgumentException(SerializeUtils.class.getSimpleName() + " requires a Serializable payload " + "but received an object of type [" + object.getClass().getName() + "]");
                    }

                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteStream);
                    objectOutputStream.writeObject(object);
                    objectOutputStream.flush();
                    result = byteStream.toByteArray();
                } catch (Throwable var4) {
                    throw new Exception("Failed to serialize", var4);
                }
            } catch (Exception var5) {
                logger.error("Failed to serialize", var5);
            }

            return result;
        }
    }
}
