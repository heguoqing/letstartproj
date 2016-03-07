package com.common.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES加密算法
 * 
 */
public class DESEncrypt
{

	private static DESEncrypt desEncrypt = new DESEncrypt();
	public static final int strLength = 16;

	public static DESEncrypt getInstance()
	{
		return desEncrypt;
	}

	/**
	 * 字符不足位数补零
	 * 
	 * @param targetStr
	 * @return
	 */
	private static String fillBlankZero(String targetStr)
	{
		int curLength = targetStr.getBytes().length;
		if (targetStr != null && curLength > strLength)
		{
			targetStr = SubStringByte(targetStr);
		}
		String newString = "";
		int cutLength = 0;
		try
		{
			cutLength = strLength - targetStr.getBytes("UTF-8").length;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		for (int i = 0; i < cutLength; i++)
		{
			newString += "0";
		}
		return targetStr + newString;
	}

	/**
	 * 截取字符
	 * 
	 * @param targetStr
	 * @return
	 */
	private static String SubStringByte(String targetStr)
	{

		while (targetStr.getBytes().length > strLength)
		{
			targetStr = targetStr.substring(0, targetStr.length() - 1);
		}
		return targetStr;
	}

	/**
	 * 解密 :以sKey为密钥，将sSrc密文解密,以明文输出
	 * 
	 * @param sSrc
	 *            密文
	 * @param sKey
	 *            密钥
	 * @return 明文
	 */
	public static String getDesString(String sSrc, String sKey)
	{

		try
		{
			// 判断Key是否正确
			if (sKey == null)
			{

				return null;
			}
			// 判断Key是否为16位
			if (sKey.length() != 16)
			{
				sKey = fillBlankZero(sKey);
			}

			byte[] raw = sKey.getBytes("UTF-8");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			byte[] encrypted1 = hex2byte(sSrc);
			try
			{
				byte[] original = cipher.doFinal(encrypted1);
				String originalString = new String(original);
				return originalString;
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 加密：以sKey为密钥,加密sSrc字符，输出密文
	 * 
	 * @param sSrc
	 *            明文
	 * @param sKey
	 *            密钥
	 * @return 密文
	 */
	public static String getEncString(String sSrc, String sKey)
	{
		if (sKey == null)
		{
			System.out.print("Key为空null");
			return null;
		}
		// 判断Key是否为16位
		if (sKey.length() != 16)
		{
			sKey = fillBlankZero(sKey);
		}

		try
		{
			byte[] raw = sKey.getBytes("UTF-8");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			byte[] encrypted = cipher.doFinal(sSrc.getBytes());
			return byte2hex(encrypted).toLowerCase();
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}

	public static byte[] hex2byte(String strhex)
	{
		if (strhex == null)
		{
			return null;
		}
		int l = strhex.length();
		if (l % 2 == 1)
		{
			return null;
		}
		byte[] b = new byte[l / 2];
		for (int i = 0; i != l / 2; i++)
		{
			b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2),
					16);
		}
		return b;
	}

	public static String byte2hex(byte[] b)
	{
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++)
		{
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
			{
				hs = hs + "0" + stmp;
			} else
			{
				hs = hs + stmp;
			}
		}
		return hs.toUpperCase();
	}

	public static void main(String[] args)
	{
		System.out.println(getEncString("Youzhu123", "email_key"));
		System.out.println(getEncString("adfje14Ee&3ksKdf", "mysql_key"));
		System.out.println(getEncString("adfje14Ee&amp;3ksKdf", "mysql_key"));
		System.out.println(getDesString("759d201f8b8376ef1749570b011493c43f2ade67faa871c3eab81ae9c536d1d2","mysql_key"));
		System.out.println(getDesString("a90f7a0dde1e3f17553c9a1024a212c3", "mysql_key"));
	}
}
