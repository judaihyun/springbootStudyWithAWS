

let main = {
    init : function(){
        var _this = this;
        $('#btn-save').on('click', ()=>{
            _this.save();
        });

        $('#btn-update').on('click', ()=>{
            _this.update();
        });

        $('#btn-delete').on('click', ()=>{
            _this.delete();
        });
    },
    save : function(){
        let data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val(),
        };

        console.log(data);
        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(()=>{
            alert('글이 등록됨.');
            window.location.href = '/';
        }).fail((error)=>{
            alert(JSON.stringify(error));
        })
    },
    update : function(){
        let data = {
            title: $('#title').val(),
            content: $('#content').val(),
        };

        var id = $('#id').val();
        console.log(data);

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(()=>{
            alert('글이 수정됨.');
            window.location.href = '/';
        }).fail((error) =>{
            alert(JSON.stringify(error));
        })
    },
    delete : function(){
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
        }).done(()=>{
            alert('글이 삭제됨.');
            window.location.href = '/';
        }).fail((error) =>{
            alert(JSON.stringify(error));
        })
    },
}

main.init();