export home_d='/cygdrive/d'
export home_ws=$home_d'/work/workspace'

export PATH="$PATH:$home_ws/hello-tutorial-world/hello-shell/bin"

alias ssh_xiaomi='ssh root@192.168.31.1'

alias ssh_fortress='ssh -p2201 root@203.100.83.126'

alias ssh_data_mine='ssh root@101.201.39.94'
alias ssh_web01='ssh root@123.56.186.60'
alias ssh_monitor='ssh root@101.200.204.53'
alias ssh_backmgr='ssh jianfeng@123.56.186.120'

alias ssh_5='ssh root@192.168.2.5'
alias ssh_7='ssh root@192.168.2.7'

alias mysql_test='mysql -h192.168.2.7 -ujft -p3edcvBHU8 -P3306 jft_master'
alias mysql_activity='mysql -h101.201.39.94 -ujft -p8uHbVcDe3 -P3307 jft_activity'
alias mysql_stat='mysql -h101.201.39.94 -ujf_stat -p"p7Wb&*i<3Ne," jft_stat'
alias mysql_order_slave='mysql -h101.201.39.94 -ujfread -p"T9iv#(k2ju;h" jft_order'
alias mysql_master_slave='mysql -h101.201.39.94 -ujfread -p"T9iv#(k2ju;h" jft_master'

alias t='tmux'

alias cd_home='cd $home_d'
alias cd_ws='cd $home_ws'

alias less_bash='less ~/.bashrc'
alias less_log='less /cygdrive/d/aliyun/logs/app.log'

alias cat_log='cat /dev/null> /cygdrive/d/aliyun/logs/app.log'

#symbolic link
#ln -s /cygdrive/c/Windows/system32/PING.EXE ping.exe



tmux_init(){
    tmux new-session -s "happy" -d -n "local"    # 开启一个会话
    tmux new-window -n "mysql"          # 开启一个窗口
    tmux new-window -n "log" 
    tmux new-window -n "server"
    #tmux split-window -h                # 开启一个竖屏
    #tmux split-window -v "top"          # 开启一个横屏,并执行top命令
    tmux -2 attach-session -d           # tmux -2强制启用256color，连接已开启的tmux
}
# 判断是否已有开启的tmux会话，没有则开启
if which tmux >/dev/null 2>&1; then
    test -z "$TMUX" && (tmux attach > /dev/null 2>&1 || tmux_init)
fi


