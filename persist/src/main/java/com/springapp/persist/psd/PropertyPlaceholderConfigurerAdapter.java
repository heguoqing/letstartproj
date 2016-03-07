package com.springapp.persist.psd;

import com.common.util.DESEncrypt;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.AbstractFileResolvingResource;
import org.springframework.core.io.Resource;
import org.springframework.util.DefaultPropertiesPersister;
import org.springframework.util.PropertiesPersister;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public final class PropertyPlaceholderConfigurerAdapter extends
		PropertyPlaceholderConfigurer
{

	private static List<String> jdbcProperties = new ArrayList<String>();

	static {
		jdbcProperties.add("jdbc.properties");
	}

	private Resource[] locations;
	private String key;
	private String proName;
	private String fileEncoding;

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public String getProName()
	{
		return proName;
	}

	public void setProName(String proName)
	{
		this.proName = proName;
	}

	public String getFileEncoding()
	{
		return fileEncoding;
	}

	public void setFileEncoding(String fileEncoding)
	{
		this.fileEncoding = fileEncoding;
	}

	public Resource[] getLocations()
	{
		return locations;
	}

	public void setLocations(Resource[] locations)
	{
		this.locations = locations;
	}

	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException
	{
		try
		{
			Properties mergedProps = mergeProperties();

			// Convert the merged properties, if necessary.
			convertProperties(mergedProps);

			// Let the subclass process the properties.
			processProperties(beanFactory, mergedProps);
		} catch (IOException ex)
		{
			throw new BeanInitializationException("Could not load properties",
					ex);
		}
	}

	public void loadProperties(Properties props) throws IOException
	{
		if (this.locations != null)
		{
			PropertiesPersister propertiesPersister = new DefaultPropertiesPersister();
			for (Resource location : this.locations)
			{
				if (logger.isInfoEnabled())
				{
					logger.info("Loading properties file from " + location);
				}
				InputStream is = null;
				try
				{
					is = location.getInputStream();

					String filename = (location instanceof AbstractFileResolvingResource) ? location
							.getFilename() : null;
					if (filename != null && filename.endsWith("xml"))
					{
						propertiesPersister.loadFromXml(props, is);
					} else
					{
						if (this.fileEncoding != null)
						{
							propertiesPersister
									.load(props, new InputStreamReader(is,
											this.fileEncoding));
						} else
						{
							propertiesPersister.load(props, is);
						}
						if (jdbcProperties.contains(filename))
						{
							props.setProperty(
									proName,
									DESEncrypt.getDesString(
											props.getProperty(proName), key));
						}
					}
				} catch (IOException ex)
				{

					if (logger.isWarnEnabled())
					{
						logger.warn("Could not load properties from "
								+ location + ": " + ex.getMessage());
					} else
					{
						throw ex;
					}
				} finally
				{
					if (is != null)
					{
						is.close();
					}
				}
			}
		}
	}
}
