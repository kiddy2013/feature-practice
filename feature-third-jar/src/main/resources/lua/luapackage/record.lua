--LUA record CLASS
--jack

luaRecord = {}

--反序列化
function CreateRecord(record)
    setmetatable(record, { __index = luaRecord })
    return record
end


--获取test
function luaRecord:getTest()
    if (self['test'] == nil) then
        return nil
    end
    return self['test']
end

--设置test
function luaRecord:setTest(v)
    if (v == nil) then
        self['test'] = nil
        return
    end
    self['test'] = v
end

