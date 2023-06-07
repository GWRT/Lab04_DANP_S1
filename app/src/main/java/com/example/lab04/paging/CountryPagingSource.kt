package com.example.lab04.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.lab04.entities.Country

class CountryPagingSource(
    private val countries: List<Country>
    ) : PagingSource<Int, Country>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Country> {
        val page = params.key ?: 0
        val pageSize = params.loadSize
        val start = page * pageSize
        val end = start + pageSize
        val data = countries.subList(start, end)
        return LoadResult.Page(data, prevKey = if (page == 0) null else page - 1, nextKey = if (end >= countries.size) null else page + 1)

    }

    override fun getRefreshKey(state: PagingState<Int, Country>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}