/*
 * Copyright (c) 2017 Teradata
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.teradata.jaqy.helper;

import java.util.HashMap;
import java.util.Hashtable;

import com.teradata.jaqy.Globals;
import com.teradata.jaqy.connection.JaqyConnection;
import com.teradata.jaqy.connection.JdbcFeatures;
import com.teradata.jaqy.interfaces.JaqyHelper;
import com.teradata.jaqy.interfaces.JaqyHelperFactory;
import com.teradata.jaqy.utils.SimpleQuery;

/**
 * @author	Heng Yuan
 */
public class DefaultHelperFactory implements JaqyHelperFactory
{
	private Hashtable<String,SimpleQuery> m_sqlMap = new Hashtable<String,SimpleQuery> ();
	private JdbcFeatures m_features = new JdbcFeatures ();

	public DefaultHelperFactory ()
	{
	}

	protected DefaultHelper createHelper (JdbcFeatures features, JaqyConnection conn, Globals globals)
	{
		return new DefaultHelper (getFeatures(), conn, globals);
	}

	@Override
	public JaqyHelper getHelper (JaqyConnection conn, Globals globals)
	{
		DefaultHelper helper = createHelper (getFeatures (), conn, globals);
		setupHelper (helper);
		return helper;
	}

	protected void setupHelper (DefaultHelper helper)
	{
		helper.setCatalogQuery (m_sqlMap.get ("catalogSQL"));
		helper.setSchemaQuery (m_sqlMap.get ("schemaSQL"));
		helper.setTableColumnQuery (m_sqlMap.get ("tableColumnSQL"));
		helper.setTableSchemaQuery (m_sqlMap.get ("tableSchemaSQL"));
	}

	public JdbcFeatures getFeatures ()
	{
		return m_features;
	}

	public void setFeatures (JdbcFeatures features)
	{
		m_features = features;
	}

	public void setSQLMap (HashMap<String,SimpleQuery> sqls)
	{
		m_sqlMap.putAll (sqls);
	}
}
