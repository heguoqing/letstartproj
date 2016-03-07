package com.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Encrypt
{
	/**
	 * Used building output as Hex
	 */
	private static final char[] DIGITS =
	{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
			'e', 'f' };

	public static String md5(String text)
	{
		MessageDigest msgDigest = null;

		try
		{
			msgDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e)
		{
			throw new IllegalStateException(
					"System doesn't support MD5 algorithm.");
		}

		try
		{
			msgDigest.update(text.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e)
		{

			throw new IllegalStateException(
					"System doesn't support your  EncodingException.");

		}

		byte[] bytes = msgDigest.digest();

		String md5Str = new String(encodeHex(bytes));

		return md5Str;
	}

	public static char[] encodeHex(byte[] data)
	{

		int l = data.length;

		char[] out = new char[l << 1];

		// two characters form the hex value.
		for (int i = 0, j = 0; i < l; i++)
		{
			out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
			out[j++] = DIGITS[0x0F & data[i]];
		}

		return out;
	}

	public static void main(String[] args) throws UnsupportedEncodingException
	{
		System.out.println(md5("888888"));
		System.out.println(md5("123456789"));
		System.out.println(md5("123456"));
		System.out.println(md5("654321"));
		System.out.println(md5("dabacd2394jfkdak!@*xxdaf"));
		System.out.println(md5("dabacd2394jfkdak!@*xxdafpc"));
		System.out.println(md5("20151204175151c2q14zc9alipay015402e4aa5971b535e5dc72e969a9c8"));

		// try {
		// String valueStr = new String("�Ϻ���֮��".getBytes("ISO-8859-1"),
		// "GBK");
		// System.out.println(valueStr);
		// } catch (UnsupportedEncodingException e) {
		// e.printStackTrace();
		// }

	}

}