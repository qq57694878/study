package cn.com.jldata.search.spmsearch.common.util;


/**
 * Created by jinliang on 2016/7/28.
 */
public class MD5Encoder {

    /**
     * Used by subclasses to extract the password and salt from a merged <code>String</code> created using
     * {@link #mergePasswordAndSalt(String,Object,boolean)}.<p>The first element in the returned array is the
     * password. The second element is the salt. The salt array element will always be present, even if no salt was
     * found in the <code>mergedPasswordSalt</code> argument.</p>
     *
     * @param mergedPasswordSalt as generated by <code>mergePasswordAndSalt</code>
     *
     * @return an array, in which the first element is the password and the second the salt
     *
     * @throws IllegalArgumentException if mergedPasswordSalt is null or empty.
     */
    private static String[] demergePasswordAndSalt(String mergedPasswordSalt) {
        if ((mergedPasswordSalt == null) || "".equals(mergedPasswordSalt)) {
            throw new IllegalArgumentException("Cannot pass a null or empty String");
        }

        String password = mergedPasswordSalt;
        String salt = "";

        int saltBegins = mergedPasswordSalt.lastIndexOf("{");

        if ((saltBegins != -1) && ((saltBegins + 1) < mergedPasswordSalt.length())) {
            salt = mergedPasswordSalt.substring(saltBegins + 1, mergedPasswordSalt.length() - 1);
            password = mergedPasswordSalt.substring(0, saltBegins);
        }

        return new String[] {password, salt};
    }

    /**
     * Used by subclasses to generate a merged password and salt <code>String</code>.<P>The generated password
     * will be in the form of <code>password{salt}</code>.</p>
     *  <p>A <code>null</code> can be passed to either method, and will be handled correctly. If the
     * <code>salt</code> is <code>null</code> or empty, the resulting generated password will simply be the passed
     * <code>password</code>. The <code>toString</code> method of the <code>salt</code> will be used to represent the
     * salt.</p>
     *
     * @param password the password to be used (can be <code>null</code>)
     * @param salt the salt to be used (can be <code>null</code>)
     * @param strict ensures salt doesn't contain the delimiters
     *
     * @return a merged password and salt <code>String</code>
     *
     * @throws IllegalArgumentException if the salt contains '{' or '}' characters.
     */
    private static String mergePasswordAndSalt(String password, Object salt, boolean strict) {
        if (password == null) {
            password = "";
        }

        if (strict && (salt != null)) {
            if ((salt.toString().lastIndexOf("{") != -1) || (salt.toString().lastIndexOf("}") != -1)) {
                throw new IllegalArgumentException("Cannot use { or } in salt.toString()");
            }
        }

        if ((salt == null) || "".equals(salt)) {
            return password;
        } else {
            return password + "{" + salt.toString() + "}";
        }
    }

    /**
     * Encodes the rawPass using a MessageDigest.
     * If a salt is specified it will be merged with the password before encoding.
     *
     * @param password The plain text password
     * @param salt The salt to sprinkle
     * @return Hex string of password digest (or base64 encoded string if encodeHashAsBase64 is enabled.
     */
    public static String encode(String password, Object salt) {
        String saltedPass = mergePasswordAndSalt(password, salt, false);
        return  Md5Utils.getMd5(saltedPass);
    }

}
