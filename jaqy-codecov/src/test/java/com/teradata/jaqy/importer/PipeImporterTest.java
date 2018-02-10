/*
 * Copyright (c) 2017-2018 Teradata
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
package com.teradata.jaqy.importer;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.teradata.jaqy.utils.TestUtils;

/**
 * @author	Heng Yuan
 */
public class PipeImporterTest
{
	@Rule
	public TemporaryFolder testFolder = new TemporaryFolder ();

	@Test
	public void test1 () throws Exception
	{
		TestUtils.jaqyTest (testFolder, "../tests/unittests/pipe/pipe_1.sql", "../tests/unittests/pipe/control/pipe_1.control");
	}

	@Test
	public void test2 () throws Exception
	{
		TestUtils.jaqyTest (testFolder, "../tests/unittests/pipe/pipe_2.sql", "../tests/unittests/pipe/control/pipe_2.control");
	}

	@Test
	public void test3 () throws Exception
	{
		TestUtils.jaqyTest (testFolder, "../tests/unittests/pipe/pipe_3.sql", "../tests/unittests/pipe/control/pipe_3.control");
	}

	@Test
	public void test4 () throws Exception
	{
		TestUtils.jaqyTest (testFolder, "../tests/unittests/pipe/pipe_4.sql", "../tests/unittests/pipe/control/pipe_4.control");
	}

	@Test
	public void test5 () throws Exception
	{
		TestUtils.jaqyTest (testFolder, "../tests/unittests/pipe/pipe_5.sql", "../tests/unittests/pipe/control/pipe_5.control");
	}

	@Test
	public void test6 () throws Exception
	{
		TestUtils.jaqyTest (testFolder, "../tests/unittests/pipe/pipe_6.sql", "../tests/unittests/pipe/control/pipe_6.control");
	}
}
