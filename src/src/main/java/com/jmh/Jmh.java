package com.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.*;
import java.util.concurrent.TimeUnit;

import pkg.*;

@State(Scope.Thread)
public class Jmh {

	//final int numThreads = ;
	JMHBro jb1 = new JMHBro();
	JMHBro jb2 = new JMHBro();
	JMHBro jb4 = new JMHBro();
	JMHBro jb8 = new JMHBro();
	JMHBro jb16 = new JMHBro();
	JMHBro jb32 = new JMHBro();
	JMHBro jb64 = new JMHBro();
	JMHBro jb128 = new JMHBro();
	JMHBro jb256 = new JMHBro();
	
//This class includes all JMH  appropriate tests for a one shot
//execution. This incluses tests for two diffrent hashmaps:
//JDK Concurrent HashMap and "Matt" Hashmap
//all testing multithred with the same four basic tests
//run on 1, 2, 4, 8, 16, 32, 64, 128, and 256 Threads. 
//all of these Threads are put() and remove() focused, 
//see "JMHBro.java" for full testing sequence.

	public static void main(String[] args) throws RunnerException{
		Options o = new OptionsBuilder()
			.include(Jmh.class.getSimpleName())
			.forks(1)
			.build();

		new Runner(o).run();
	}
//Small Dataset Matt's HashMap 1 Thread
	@Benchmark
	@Threads(1)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test11SDMHM1T() {
		jb1.smallDataMHM();
	}

//Small Dataset Concurrent HashMap 1 Thread
	@Benchmark
	@Threads(1)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test12SDCHM1T() {
		jb1.smallDataCHM();
	}
	
//Large Dataset Matt's HashMap 1 Thread
	@Benchmark
	@Threads(1)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test21LDMHM1T() {
		jb1.largeDataMHM();
	}
//Large Dataset Concurrent HashMap 1 Thread
	@Benchmark
	@Threads(1)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test22LDCHM1T() {
		jb1.largeDataCHM();
	}
///
///
///
//Small Dataset Matt's HashMap 2 Thread
	@Benchmark
	@Threads(2)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test11SDMHM2T() {
		jb2.smallDataMHM();
	}

//Small Dataset Concurrent HashMap 2 Thread
	@Benchmark
	@Threads(2)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test12SDCHM2T() {
		jb2.smallDataCHM();
	}
	
//Large Dataset Matt's HashMap 2 Thread
	@Benchmark
	@Threads(2)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test21LDMHM2T() {
		jb2.largeDataMHM();
	}
//Large Dataset Concurrent HashMap 2 Thread
	@Benchmark
	@Threads(2)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test22LDCHM2T() {
		jb2.largeDataCHM();
	}	
///
///
///
//Small Dataset Matt's HashMap 4 Thread
	@Benchmark
	@Threads(4)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test11SDMHM4T() {
		jb4.smallDataMHM();
	}

//Small Dataset Concurrent HashMap 4 Thread
	@Benchmark
	@Threads(4)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test12SDCHM4T() {
		jb4.smallDataCHM();
	}
	
//Large Dataset Matt's HashMap 4 Thread
	@Benchmark
	@Threads(4)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test21LDMHM4T() {
		jb4.largeDataMHM();
	}
//Large Dataset Concurrent HashMap 4 Thread
	@Benchmark
	@Threads(4)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test22LDCHM4T() {
		jb4.largeDataCHM();
	}
///
///
///
//Small Dataset Matt's HashMap 8 Thread
	@Benchmark
	@Threads(8)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test11SDMHM8T() {
		jb8.smallDataMHM();
	}

//Small Dataset Concurrent HashMap 8 Thread
	@Benchmark
	@Threads(8)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test12SDCHM8T() {
		jb8.smallDataCHM();
	}
	
//Large Dataset Matt's HashMap 8 Thread
	@Benchmark
	@Threads(8)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test21LDMHM8T() {
		jb8.largeDataMHM();
	}
//Large Dataset Concurrent HashMap 8 Thread
	@Benchmark
	@Threads(8)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test22LDCHM8T() {
		jb8.largeDataCHM();
	}
///
///
///
//Small Dataset Matt's HashMap 16 Thread
	@Benchmark
	@Threads(16)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test11SDMHM16T() {
		jb16.smallDataMHM();
	}

//Small Dataset Concurrent HashMap 16 Thread
	@Benchmark
	@Threads(16)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test12SDCHM16() {
		jb16.smallDataCHM();
	}
	
//Large Dataset Matt's HashMap 16 Thread
	@Benchmark
	@Threads(16)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test21LDMHM16T() {
		jb16.largeDataMHM();
	}
//Large Dataset Concurrent HashMap 16 Thread
	@Benchmark
	@Threads(16)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test22LDCHM16T() {
		jb16.largeDataCHM();
	}	
///
///
///
//Small Dataset Matt's HashMap 32 Thread
	@Benchmark
	@Threads(32)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test11SDMHM32T() {
		jb32.smallDataMHM();
	}

//Small Dataset Concurrent HashMap 32 Thread
	@Benchmark
	@Threads(32)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test12SDCHM32T() {
		jb32.smallDataCHM();
	}
	
//Large Dataset Matt's HashMap 32 Thread
	@Benchmark
	@Threads(32)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test21LDMHM32T() {
		jb32.largeDataMHM();
	}
//Large Dataset Concurrent HashMap 32 Thread
	@Benchmark
	@Threads(32)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test22LDCHM32T() {
		jb32.largeDataCHM();
	}
///
///
///
//Small Dataset Matt's HashMap 64 Thread
	@Benchmark
	@Threads(64)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test11SDMHM64T() {
		jb64.smallDataMHM();
	}
//Small Dataset Concurrent HashMap 64 Thread
	@Benchmark
	@Threads(64)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test12SDCHM64T() {
		jb64.smallDataCHM();
	}
	
//Large Dataset Matt's HashMap 64 Thread
	@Benchmark
	@Threads(64)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test21LDMHM64T() {
		jb64.largeDataMHM();
	}
//Large Dataset Concurrent HashMap 64 Thread
	@Benchmark
	@Threads(64)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test22LDCHM64T() {
		jb64.largeDataCHM();
	}
///
///
///
//Small Dataset Matt's HashMap 128 Thread
	@Benchmark
	@Threads(128)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test11SDMHM128T() {
		jb128.smallDataMHM();
	}

//Small Dataset Concurrent HashMap 128 Thread
	@Benchmark
	@Threads(128)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test12SDCHM128T() {
		jb128.smallDataCHM();
	}
	
//Large Dataset Matt's HashMap 128 Thread
	@Benchmark
	@Threads(128)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test21LDMHM128T() {
		jb128.largeDataMHM();
	}
//Large Dataset Concurrent HashMap 128 Thread
	@Benchmark
	@Threads(128)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test22LDCHM128T() {
		jb128.largeDataCHM();
	}	
///
///
///
//Small Dataset Matt's HashMap 256 Thread
	@Benchmark
	@Threads(256)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test11SDMHM256T() {
		jb256.smallDataMHM();
	}

//Small Dataset Concurrent HashMap 256 Thread
	@Benchmark
	@Threads(256)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test12SDCHM256T() {
		jb256.smallDataCHM();
	}
	
//Large Dataset Matt's HashMap 256 Thread
	@Benchmark
	@Threads(256)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test21LDMHM256T() {
		jb256.largeDataMHM();
	}
//Large Dataset Concurrent HashMap 256 Thread
	@Benchmark
	@Threads(256)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void test22LDCHM256T() {
		jb256.largeDataCHM();
	}
///
///
///
}
